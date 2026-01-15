package com.example.protect.controller;


import com.example.protect.model.Coupon;
import com.example.protect.repos.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.css.Counter;

@RestController
@RequestMapping("/couponapi")
public class CouponController {

    @Autowired
   private CouponRepo couponRepo;

    @RequestMapping(value="/coupons",method = RequestMethod.POST)
    public Coupon create(@RequestBody Coupon coupon){
        return couponRepo.save(coupon);
    }

@RequestMapping(value = "/coupons/{code}",method=RequestMethod.GET)
    public Coupon getCoupon(@PathVariable("code") String code){
        return couponRepo.findByCode(code);
    }

}
