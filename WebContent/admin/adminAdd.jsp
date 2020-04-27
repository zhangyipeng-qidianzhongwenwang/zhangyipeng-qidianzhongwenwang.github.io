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
        <link rel="stylesheet" href="/hagen_dazs/css/font.css">
        <link rel="stylesheet" href="/hagen_dazs/css/xadmin.css">
        <script type="text/javascript" src="/hagen_dazs/lib/layui/layui.js" charset="utf-8"></script>
        <script type="text/javascript" src="/hagen_dazs/js/xadmin.js"></script>
    </head>
    <body>
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form" method="post" action="/起点中文网/AdminAdd">
                    <div class="layui-form-item">
                        <label for="L_account" class="layui-form-label">
                            <span class="x-red">*</span>用户名</label>
                        <div class="layui-input-inline">
                            <input type="text" id="L_account" name="account"  required="" lay-verify="account" autocomplete="off" class="layui-input" onblur="fun()" ></div><span id="spanNameMessage"></span><br/>
                    </div>
                    <div class="layui-form-item">
                        <label for="L_adminPass" class="layui-form-label">
                            <span class="x-red">*</span>密码</label>
                        <div class="layui-input-inline">
                            <input type="password" id="L_adminPass" name="adminPass" required="" lay-verify="pass" autocomplete="off" class="layui-input"></div>
                        <div class="layui-form-mid layui-word-aux">6到12个字符</div></div>
                    <div class="layui-form-item">
                        <label for="L_reAdminPass" class="layui-form-label">
                            <span class="x-red">*</span>确认密码</label>
                        <div class="layui-input-inline">
                            <input type="password" id="L_reAdminPass" name="reAdminPass" required="" lay-verify="repass" autocomplete="off" class="layui-input"></div>
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
                	account: function(value) {
                        if (value.length < 5) {
                            return '账号至少得5个字符啊';
                        }
                    },
                    pass: [/(.+){6,12}$/, '密码必须6到12位'],
                    repass: function(value) {
                        if ($('#L_reAdminPass').val() != $('#L_adminPass').val()) {
                            return '两次密码不一致';
                        }
                    }
                });               
                form.onSubmit();
                function fun() {
        			var account = document.getElementById("account").value;
          			//1、创建xhr对象
          			try {
          				xhr = new ActiveXObject("Microsoft.XMLHTTP");
          			} catch (e) {
          				try {
          					xhr = new XMLHttpRequest();
          				} catch (ee) {
          					try {
          						xhr = new ActiveXObject("Msxml2.XMLHTTP");
          					} catch (eee) {
          						alert('该换浏览器了！浏览器不支持Ajax！');
          					}
          				}
          			}

          			if (xhr) {
          				//2、创建Ajax请求，Ajax也有两种请求形式get post
          				xhr.open("post", "/hagen_dazs/AdminAdd?account="+account);

          				//3、发送Ajax请求
          				xhr.send(null);
          				
        				xhr.onreadystatechange = function() {
          					if (xhr.readyState == 4) {
          						//4、处理服务器响应
          						var data = xhr.responseText;

          						//消息展示容器
          						var span = document.getElementById("spanNameMessage");
          						if (data == "1") {
          							span.style.border = "solid 1px green";
          							span.innerHTML = '恭喜，O(∩_∩)O哈哈~可以使用';
          						} else {
          							span.style.border = "solid 1px red";
          							span.innerHTML = '-_-!!!,不可以使用';
          						}
          					}
          				};
          			}

          		}
                /*
                //监听提交
                form.on('submit(add)',
                function(data) {
                    console.log(data);
                    //发异步，把数据提交给php
                    layer.alert("增加成功", {
                        icon: 6
                    },
                    function() {
                        //关闭当前frame
                        xadmin.close();

                        // 可以对父窗口进行刷新 
                        xadmin.father_reload();
                    });
                    return false;
                });
				*/
            });</script>
    </body>

</html>