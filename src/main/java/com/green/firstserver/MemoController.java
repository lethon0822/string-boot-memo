package com.green.firstserver;

import com.green.firstserver.modelVO.MemoGetOneRes;
import com.green.firstserver.modelVO.MemoGetRes;
import com.green.firstserver.modelVO.MemoPostReq;
import com.green.firstserver.modelVO.MemoPutReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 빈(Bean)등록 : 스프링 컨테이너 객체 생성을 대리로 맡긴다. 요청/응답 담당자
@RequiredArgsConstructor    // DI를 위한 생성자 생성, final 붙은 친구들 초기화
public class MemoController {

    // DI 받는 방법 3가지
    // 1) 필드 주입, 2) setter(메소드) 주입, 3) 생성자 주입★
    private final MemoService memoService;

    // 리스트
    @GetMapping("/memo")
    public List<MemoGetRes> memo(){
        return memoService.selMemoList();
    }

    @GetMapping("/memo/{id}")
    public MemoGetOneRes getMemo(@PathVariable int id){
        return memoService.selMemo(id);
    }

    @PostMapping("/memo")
    public String postMemo(@RequestBody MemoPostReq req){   // @RequestBody : JSON으로 보낸 데이터를 받음
        System.out.println("postMemo:"+req);
        int result = memoService.insMemo(req);
        return result == 1 ? "성공" : "실패";
    }

    @PutMapping("/memo")
    // @PathVariable int id, 제외
    public String putMemo(@RequestBody MemoPutReq req){
        System.out.println("putMemo:"+req);
        int result = memoService.updMemo(req);
        return result == 1 ? "성공" : "실패";
    }

    @DeleteMapping("/memo")
    public String deleteMemo(@RequestParam int id){
        System.out.println("deleteMemo:"+id);
        int result = memoService.delMemo(id);
        return result == 1 ? "성공" : "실패";
    }
}
