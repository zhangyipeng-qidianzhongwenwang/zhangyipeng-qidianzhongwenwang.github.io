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
                <form class="layui-form" method="post" action="/起点中文网/TypeAdd">
                    <div class="layui-form-item">
                        <label for="L_account" class="layui-form-label">
                            <span class="x-red">*</span>类型名</label>
                        <div class="layui-input-inline">
                            <input type="text" id="L_account" name="type"  required="" lay-verify="account" autocomplete="off" class="layui-input"  >
                    
                    </div>
                    
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
               
                form.onSubmit();
               </script>
    </body>

</html>