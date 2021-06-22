package com.wq.xxx.polygon;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
 * TODO
 * Created by wuqiang on 2021/3/11-10:04
 */
public class OrderMapTest {
    
    
    public static void main(String[] args) {
    
        long timestamp = UUID.randomUUID().timestamp();
        // 被检测的经纬度点
        long start = System.currentTimeMillis();
        GeoPoint orderLocation = new GeoPoint(35.2, 120.5);
        // 商业区域（百度多边形区域经纬度集合）
        String partitionLocation = "31_112.5,30_123.5,45_130.3,35_120.3,40_115.7";
        System.out.println(isInPolygon(orderLocation, partitionLocation) + " cost : " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        List<Point2D.Double> polygon = new ArrayList<>();
        polygon.add(new Point2D.Double(30, 100));
        polygon.add(new Point2D.Double(32, 102));
        polygon.add(new Point2D.Double(32, 100));
        polygon.add(new Point2D.Double(31, 100.5));
//        polygon.add(new Point2D.Double(40, 115.7));
        System.out.println(checkWithJdkGeneralPath(new Point2D.Double(30, 100), polygon) + " cost :" + (System.currentTimeMillis() - start));
    }
    
    /**
     * 判断当前位置是否在多边形区域内
     * @param orderLocation 当前点
     * @param partitionLocation 区域顶点
     * @return
     */
    public static boolean isInPolygon(GeoPoint orderLocation, String partitionLocation){
        double oriLon =orderLocation.getLon();
        double oriLat =orderLocation.getLat();
        Point2D.Double point = new Point2D.Double(oriLon, oriLat);
        
        List<Point2D.Double> pointList= new ArrayList<Point2D.Double>();
        String[] strList = partitionLocation.split(",");
        
        for (String str : strList){
            String[] points = str.split("_");
            double polygonPoint_x=Double.parseDouble(points[1]);
            double polygonPoint_y=Double.parseDouble(points[0]);
            Point2D.Double polygonPoint = new Point2D.Double(polygonPoint_x,polygonPoint_y);
            pointList.add(polygonPoint);
        }
        return IsPtInPoly(point,pointList);
    }
    /**
     * 返回一个点是否在一个多边形区域内， 如果点位于多边形的顶点或边上，不算做点在多边形内，返回false
     * @param point
     * @param polygon
     * @return
     */
    public static boolean checkWithJdkGeneralPath(Point2D.Double point, List<Point2D.Double> polygon) {
        java.awt.geom.GeneralPath p = new java.awt.geom.GeneralPath();
        Point2D.Double first = polygon.get(0);
        p.moveTo(first.x, first.y);
        polygon.remove(0);
        for (Point2D.Double d : polygon) {
            p.lineTo(d.x, d.y);
        }
        p.lineTo(first.x, first.y);
        p.closePath();
        return p.contains(point);
    }
    
    /**
     * 判断点是否在多边形内，如果点位于多边形的顶点或边上，也算做点在多边形内，直接返回true
     * @param point 检测点
     * @param pts   多边形的顶点
     * @return      点在多边形内返回true,否则返回false
     */
    public static boolean IsPtInPoly(Point2D.Double point, List<Point2D.Double> pts){
        
        int N = pts.size();
        boolean boundOrVertex = true; //如果点位于多边形的顶点或边上，也算做点在多边形内，直接返回true
        int intersectCount = 0;//cross points count of x
        double precision = 2e-10; //浮点类型计算时候与0比较时候的容差
        Point2D.Double p1, p2;//neighbour bound vertices
        Point2D.Double p = point; //当前点
        
        p1 = pts.get(0);//left vertex
        for(int i = 1; i <= N; ++i){//check all rays
            if(p.equals(p1)){
                return boundOrVertex;//p is an vertex
            }
            
            p2 = pts.get(i % N);//right vertex
            if(p.x < Math.min(p1.x, p2.x) || p.x > Math.max(p1.x, p2.x)){//ray is outside of our interests
                p1 = p2;
                continue;//next ray left point
            }
            
            if(p.x > Math.min(p1.x, p2.x) && p.x < Math.max(p1.x, p2.x)){//ray is crossing over by the algorithm (common part of)
                if(p.y <= Math.max(p1.y, p2.y)){//x is before of ray
                    if(p1.x == p2.x && p.y >= Math.min(p1.y, p2.y)){//overlies on a horizontal ray
                        return boundOrVertex;
                    }
                    
                    if(p1.y == p2.y){//ray is vertical
                        if(p1.y == p.y){//overlies on a vertical ray
                            return boundOrVertex;
                        }else{//before ray
                            ++intersectCount;
                        }
                    }else{//cross point on the left side
                        double xinters = (p.x - p1.x) * (p2.y - p1.y) / (p2.x - p1.x) + p1.y;//cross point of y
                        if(Math.abs(p.y - xinters) < precision){//overlies on a ray
                            return boundOrVertex;
                        }
                        
                        if(p.y < xinters){//before ray
                            ++intersectCount;
                        }
                    }
                }
            }else{//special case when ray is crossing through the vertex
                if(p.x == p2.x && p.y <= p2.y){//p crossing over p2
                    Point2D.Double p3 = pts.get((i+1) % N); //next vertex
                    if(p.x >= Math.min(p1.x, p3.x) && p.x <= Math.max(p1.x, p3.x)){//p.x lies between p1.x & p3.x
                        ++intersectCount;
                    }else{
                        intersectCount += 2;
                    }
                }
            }
            p1 = p2;//next ray left point
        }
    
        //偶数在多边形外 奇数在多边形内
        return intersectCount % 2 != 0;
    }
}