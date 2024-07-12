package com.edwyn.demo.port;

import com.edwyn.demo.domain.model.Park;
import com.edwyn.demo.domain.model.ParkType;

public interface ParkPort {
    Park findById(Long id);
    Park findByType(ParkType type);
    Park save(Park park);
}
