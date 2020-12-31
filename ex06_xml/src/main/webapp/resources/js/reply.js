console.log("Reply Module...");

//	<!--  p403 reply.js 등록 처리-->
//	<!--  p406 reply.js 댓글 목록 처리-->
//	<!--  p408 reply.js 댓글 삭제와 갱신처리-->
//	<!--  p410 reply.js 댓글 수정 처리-->
//	<!--  p412 reply.js 댓글 조회 처리-->
//	<!--  p418 reply.js 댓글 시간에 대한 처리 ->
//	<!--  p731 reply.js 스프링 시큐리티 관련 댓글 삭제 처리 ->

var replyService = (function() {

	function add(reply, callback, error) {
		console.log("add reply.....");
		
		$.ajax({
			type : 'post',
			url : '/replies/new',
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr) {
				if (callback) {
					callback(result);
				}
			},
			error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		})
	}
	// p437 댓글 페이지의 화면처리
	function getList(param, callback, error){
		var bno = param.bno;
		var page = param.page || 1;
		
		$.getJSON("/replies/pages/" + bno + "/" + page + ".json",
		 function(data){
			if(callback){
//				callback(data); 댓글 목록만 가져오는 경우이다.
				callback(data.replyCnt, data.list); // 댓글 숫자와 목록을 가져오는 경우이다.
			}
		}).fail(function(xhr, status, err){
			if(error){
				error();
			}
		});
	}
	
	function remove(rno, replyer, callback, error){
		$.ajax({
			type:'delete',
			url:'/replies/' + rno,
			data: JSON.stringify({rno:rno, replyer:replyer}),
			contentType: "application/json; charset=utf-8",
			success : function(deleteResult, status, xhr){
				if(callback){
					callback(deleteResult);
				}
			},
			error : function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		});
	}
	
	function update(reply, callback, error) {
		console.log("RNO : " + reply.rno);
		
		$.ajax({
			type : 'put',
			url : '/replies/' + reply.rno,
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr) {
				if (callback) {
					callback(result);
				}
			},
			error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		});
	}
	
	function get(rno, callback, error){
		$.get("/replies/" + rno + ".json", function(result){
			if(callback){
				callback(result);
			}
		}).fail(function(xhr, status, err){
			if(error) {
				error();
			}
		});
	}
	
	function displayTime(timeValue){
		var today = new Date();
		
		var gap = today.getTime() - timeValue;
		
		var dateObj = new Date(timeValue);
		var str = "";
		
		if(gap < (1000 * 60 * 60 * 24)){
			var hh = dateObj.getHours();
			var mi = dateObj.getMinutes();
			var ss = dateObj.getSeconds();
			
			return [(hh > 9 ? '' : '0') + hh, ':', (mi > 9 ? '' : '0') + mi, ':', (ss > 9 ? '' : '0') + ss].join('');
		} else {
			var yy = dateObj.getFullYear();
			var mm = dateObj.getMonth() + 1;
			var dd = dateObj.getDate();
			
			return [yy, '/', (mm > 9 ? '' : '0') + mm, '/', (dd > 9 ? '' : '0') + dd].join('');
		}
	}
	;
	
	return { 
		add: add,
		get : get,
		getList : getList,
		remove : remove,
		update : update,
		displayTime : displayTime
		 };
})();
