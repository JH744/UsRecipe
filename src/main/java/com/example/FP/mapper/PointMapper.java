package com.example.FP.mapper;

import com.example.FP.dto.PointDto;
import com.example.FP.entity.Point;

public class PointMapper {
    public Point toEntity(PointDto pointDto){
        Point point = new Point(pointDto.getUse_point(), pointDto.getPoint_content(), pointDto.getPoint_member(),pointDto.getPoint_orders());
        return point;

    }
}
