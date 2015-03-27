package com.softserveinc.if052_restful.service;

import com.softserveinc.if052_restful.domain.Indicator;
import com.softserveinc.if052_restful.domain.WaterMeter;
import com.softserveinc.if052_restful.mappers.IndicatorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Maksym Vynnyk on 02.02.2015.
 */
@Service
@Transactional
public class IndicatorService {
    @Autowired
    private IndicatorMapper indicatorMapper;

    public Indicator getIndicatorById(int indicatorId)  {
        return indicatorMapper.getIndicatorById(indicatorId);
    }

    public List<Indicator> getAllIndicators() {
        return indicatorMapper.getAllIndicators();
    }

    public List<Indicator> getIndicatorsByWaterMeter(WaterMeter waterMeter) {
        return indicatorMapper.getIndicatorsByWaterMeter(waterMeter.getWaterMeterId());
    }

    public void insertIndicator(Indicator indicator) {
        indicatorMapper.insertIndicator(indicator);
    }

    public void updateIndicator(Indicator indicator) {
            indicatorMapper.updateIndicator(indicator);
    }

    public void deleteIndicator(int indicatorId) {
            indicatorMapper.deleteIndicator(indicatorId);
    }

    public Date getMinDate() {
        return indicatorMapper.getMinDate();
    }
}
