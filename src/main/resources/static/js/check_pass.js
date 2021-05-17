'use strict';
 $(function() {
 $('.password').on("keyup", function() {
 let hostUrl = "http://localhost:8080/passcheck/check";
 let pass = $("#pass").val();
 let pass2 = $("#pass2").val();
 $.ajax({
 url : hostUrl,
 type : "POST",
 dataType : "json",
 data : {
 pass  : pass,
 pass2 : pass2
 },
 async: true // ⾮同期で処理を⾏う
 }).done(function(data) {
 // コンソールに取得データを表⽰
 console.log(data);
 console.dir(JSON.stringify(data));
 $("#duplicateMessage").text(data.duplicateMessage);
 $("#duplicateMessage2").text(data.duplicateMessage2);
 }).fail(function(XMLHttpRequest, textStatus, errorThrown) {
 alert("エラーが発⽣しました︕");
 console.log("XMLHttpRequest : " + XMLHttpRequest.status);
 console.log("textStatus : " + textStatus);
 console.log("errorThrown : " + errorThrown.message);
 });
 });
 });