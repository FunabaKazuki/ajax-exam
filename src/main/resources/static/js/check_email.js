'use strict';
 $(function() {
 $('#email').on("keyup", function() {
 let hostUrl = "http://localhost:8080/checkemail/check";
 let inputEmail = $("#email").val();
 $.ajax({
 url : hostUrl,
 type : "POST",
 dataType : "json",
 data : {
 email : inputEmail
 },
 async: true // ⾮同期で処理を⾏う
 }).done(function(data) {
 // コンソールに取得データを表⽰
 console.log(data);
 console.dir(JSON.stringify(data));
 $("#duplicateMessage").text(data.duplicateMessage);
 }).fail(function(XMLHttpRequest, textStatus, errorThrown) {
 alert("エラーが発⽣しました︕");
 console.log("XMLHttpRequest : " + XMLHttpRequest.status);
 console.log("textStatus : " + textStatus);
 console.log("errorThrown : " + errorThrown.message);
 });
 });
 });