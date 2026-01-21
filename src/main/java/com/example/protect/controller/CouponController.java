/*package com.example.protect.controller;


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

   @PostMapping("/coupons")
    public Coupon create(@RequestBody Coupon coupon){
        return couponRepo.save(coupon);
    }

    @GetMapping("/coupons/{code}")
    public Coupon getCoupon(@PathVariable("code") String code){

       return couponRepo.findByCode(code);
    }

}*/
package com.example.protect.controller;

import com.example.protect.model.Coupon;
import com.example.protect.repos.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class CouponController {

    @Autowired
    private CouponRepo repo;

    @GetMapping("/showCreateCoupon")
    public String showCreateCoupon() {

        return "createCoupon";
    }

    @PostMapping("/saveCoupon")
    public String save(Coupon coupon) {
        repo.save(coupon);
        return "createResponse";
    }

    @GetMapping("/showGetCoupon")
    public String showGetCoupon() {

        return "getCoupon";
    }

    @PostMapping("/getCoupon")
    public ModelAndView getCoupon(String code) {
        ModelAndView mav = new ModelAndView("couponDetails");
        System.out.println(code);
        mav.addObject(repo.findByCode(code));
        return mav;
    }

}

