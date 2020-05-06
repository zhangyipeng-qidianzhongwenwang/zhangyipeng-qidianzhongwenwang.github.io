<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="x-admin-sm">
    <head>
        <meta charset="UTF-8">
        <title>管理员添加页面</title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
        <link rel="stylesheet" href="${path }/css/font.css">
        <link rel="stylesheet" href="${path }/css/xadmin.css">
        <script type="text/javascript" src="${path }/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="${path }/js/xadmin.js"></script>
    </head>
    <body>
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form" method="post" action="/起点中文网/UserAdd">
                    <div class="layui-form-item">
                        <label for="L_account" class="layui-form-label">
                            <span class="x-red">*</span>用户名</label>
                        <div class="layui-input-inline">
                            <input type="text" id="L_account" name="name"  required="" lay-verify="account" autocomplete="off" class="layui-input" onblur="fun()" >
                    </div>
                   <div class="layui-form-item">
                        <label for="L_account" class="layui-form-label">
                            <span class="x-red">*</span>性别</label>
                        <div class="layui-input-inline">
                            <input type="text" id="L_account" name="sex"  required="" lay-verify="account" autocomplete="off" class="layui-input" onblur="fun()" >
                   </div>
                   <div class="layui-form-mid layui-word-aux">0：男  1：女</div>
                    </div>
                   
                    <div class="layui-form-item">
                        <label for="L_account" class="layui-form-label">
                            <span class="x-red">*</span>邮箱</label>
                        <div class="layui-input-inline">
                            <input type="text" id="L_account" name="mail"  required="" lay-verify="account" autocomplete="off" class="layui-input" onblur="fun()" >
                    </div>
                    <div class="layui-form-item">
                        <label for="L_account" class="layui-form-label">
                            <span class="x-red">*</span>电话</label>
                        <div class="layui-input-inline">
                            <input type="text" id="L_account" name="phone"  required="" lay-verify="account" autocomplete="off" class="layui-input" onblur="fun()" >
                    </div>
                    <div class="layui-form-item">
                        <label for="L_account" class="layui-form-label">
                            <span class="x-red">*</span>地址</label>
                        <div class="layui-input-inline">
                            <input type="text" id="L_account" name="address"  required="" lay-verify="account" autocomplete="off" class="layui-input" onblur="fun()" >
                    </div>
                    <div class="layui-form-item">
                        <label for="L_adminPass" class="layui-form-label">
                            <span class="x-red">*</span>密码</label>
                        <div class="layui-input-inline">
                            <input type="password" id="L_adminPass" name="password" required="" lay-verify="pass" autocomplete="off" class="layui-input"></div>
                        <div class="layui-form-mid layui-word-aux">6到12个字符</div></div>
                    <div class="layui-form-item">
                        <label for="L_reAdminPass" class="layui-form-label">
                            <span class="x-red">*</span>确认密码</label>
                        <div class="layui-input-inline">
                            <input type="password" id="L_reAdminPass" name="repassword" required="" lay-verify="repass" autocomplete="off" class="layui-input"></div>
                    </div>
                    <div class="layui-form-item">
                        <label for="L_Btn" class="layui-form-label"></label>
                        <button class="layui-btn" lay-filter="add" lay-submit="">增加</button></div>
                </form>
            </div>
        </div>
        <script>layui.use(['form', 'layer','jquery'],
            function() {
                $ = layui.jquery;
                var form = layui.form,
                layer = layui.layer;

                //自定义验证规则
                form.verify({                
                    repass: function(value) {
                        if ($('#L_reAdminPass').val() != $('#L_adminPass').val()) {
                            return '两次密码不一致';
                        }
                    }
                });               
                form.onSubmit();
               </script>
    </body>

</html>