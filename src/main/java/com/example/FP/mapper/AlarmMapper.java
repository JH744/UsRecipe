package com.example.FP.mapper;

import com.example.FP.dto.AlarmDto;
import com.example.FP.entity.Alarm;
import org.springframework.stereotype.Component;

@Component
public class AlarmMapper {

    public static Alarm toEntity(AlarmDto alarmDto){
        Alarm alarm = new Alarm(alarmDto.getAlarm_state(), alarmDto.getAlarm_msg(), alarmDto.getAlarm_member(), alarmDto.getAlarm_recipe());
        return alarm;
    }
}