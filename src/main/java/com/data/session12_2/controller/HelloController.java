package com.data.session12_2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
    //HTTP Status Code: 401 Unauthorize
    // Dữ liệu trả về:
    //    {
    //        "timestamp": "2025-07-24T09:00:00.000+00:00",
    //            "status": 401,
    //            "error": "Unauthorized",
    //            "path": "/hello"
    //    }
    //Vai tro cua Spring Security
    // Xác thực người dùng (Authentication): Kiểm tra danh tính người dùng.
    //Phân quyền truy cập (Authorization): Kiểm soát quyền truy cập vào các tài nguyên trong hệ thống.
    //Tăng cường an toàn hệ thống thông qua các cơ chế bảo vệ hiện đại.
    // Tích hợp dễ dàng với các phương thức bảo mật phổ biến như OAuth2, JWT, LDAP,...
    //-tinh nang quan trong:
    //Xác thực người dùng (User Authentication)
    //hân quyền truy cập (Authorization)
    //Bảo vệ CSRF (Cross-Site Request Forgery)
    //Cấu hình bảo mật linh hoạt


}
