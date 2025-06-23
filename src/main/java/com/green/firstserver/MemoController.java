package com.green.firstserver;

import com.green.firstserver.model.MemoPostReq;
import org.springframework.web.bind.annotation.*;

@RestController // 빈(Bead)등록 : 스프링 컨테이너 객체 생성을 대리로 맡긴다. 요청/응답 담당자
public class MemoController {

    @GetMapping("/memo")
    public String board(){
        return "Hello Memo!";
    }

    @GetMapping("/memo/{memo_id}")
    public String memo(@PathVariable("memo_id") int memo_id){
        System.out.println("memo_id:"+memo_id);
        return "Hello Memo! - memoId:" + memo_id;
    }

    @PostMapping("/memo")
    public String postMemo(@RequestBody MemoPostReq req){   // @RequestBody : JSON으로 보낸 데이터를 받음
        System.out.println("postMemo:"+req);
        return "Post Memo!";
    }
}
