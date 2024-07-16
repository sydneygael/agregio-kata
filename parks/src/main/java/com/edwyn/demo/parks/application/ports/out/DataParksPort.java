package com.edwyn.demo.parks.application.ports.out;

import com.edwyn.demo.parks.domain.Park;
import com.edwyn.demo.parks.domain.ParkType;

public interface DataParksPort {
    Park findById(Long id);

    Park findByType(ParkType type);

    Park save(Park park);
}
