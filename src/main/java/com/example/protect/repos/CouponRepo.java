package com.example.protect.repos;

import com.example.protect.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepo extends JpaRepository<Coupon, Long> {
    
    Coupon findByCode(String code);

    Coupon save(Coupon coupon);
}
