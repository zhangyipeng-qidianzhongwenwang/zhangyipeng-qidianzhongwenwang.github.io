<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ page import="com.systop.entity.Chapter" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="${path }/css/read.css">
</head>
<body>
    <div class="top">
            <div class="path">
                <span><a href="">起点中文网 ></a></span>
                <span><a href="">${book.getTypename() } ></a></span>
                <span><a href="">${book.getB_name() } ></a></span>
                <span><a href="">第${chap.getChapterNum() } 章&nbsp;${chap.getChapterName() }</a></span>
            </div>
            <div class="style">
                    <select name="cars">
                        <option value="volvo">字体</option>
                        <option value="saab">黑体</option>
                        <option value="fiat">宋体</option>
                        <option value="audi">楷书</option>
                    </select>
                        <select name="cars">
                        <option value="volvo">大小</option>
                        <option value="saab">12px</option>
                        <option value="fiat">14px</option>
                        <option value="audi">16px</option>
                        <option value="audi">18px</option>
                        <option value="audi">20px</option>
                    </select>
                    <select name="cars">
                        <option value="volvo">颜色</option>
                        <option value="saab">红色</option>
                        <option value="fiat">黑色</option>
                        <option value="audi">蓝色</option>
                    </select>
                    <select name="cars">
                        <option value="volvo">背景</option>
                        <option value="saab">红色</option>
                        <option value="fiat">黄色</option>
                        <option value="audi">白色</option>
                    </select>
            </div>
    </div>   
    <div class="txt">           
       &nbsp;&nbsp;&nbsp; &nbsp;${chap.getText() }       
    </div>
    <div class="bottom">
            <span><a href="">投推荐票</a></span>
            <span><a href="">上一章</a></span>
            <span><a href="">章节目录</a></span>
            <span><a href="">下一章</a></span>
            <span><a href="">加入书签</a></span>
        </div>
</body>
</html>