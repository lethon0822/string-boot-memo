package com.green.firstserver;

import com.green.firstserver.modelVO.MemoGetOneRes;
import com.green.firstserver.modelVO.MemoGetRes;
import com.green.firstserver.modelVO.MemoPostReq;
import com.green.firstserver.modelVO.MemoPutReq;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

// 인터페이스가 implements한 클래스가 만들어지고 그 클래스를 객체화(주소값)
// 주소값을 스프링 컨테이너가 들고 있다.
// 스프링 컨테이너가 객체 주소값을 들고 있을 수 있는 건 빈등록이 되었기 때문

@Mapper
public interface MemoMapper {
    // insert, update, delete 는 return 타입 int 메소드로 만들기
    int insMemo(MemoPostReq req);
    List<MemoGetRes> selMemoList();
    MemoGetOneRes selMemo(int id);
    int updMemo(MemoPutReq req);
    int delMemo(int id);
}
