# SpringBoot_SpringSecurity
  增加了data.sql，用户名admin， 密码为root123，那一长串是通过BCryptPasswordEncoder生成的\
  增加了UserController，可以增加用户和查找用户，但是需要权限\
  栗子：
  1. 启动springboot\
  2. Postman执行 get请求：localhost:80/user/get?username=admin\
    返回{"msg":"Need Authorities!","status":"000"}
   3. post请求：localhost:80/login?username=admin&password=root123
   返回：{"msg":"Login Success!","status":"200"}
   4. 然后在重复执行第2步的get请求\
   返回：
```
{
  "id": 1,
  "username": "admin",
  "password": "$2a$10$yZzSDC2pBLfRNfpWPoBEE.wy766JwPcMiq5lQb2KuK9ewSM4hZc1S"
}
```
  
