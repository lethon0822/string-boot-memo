package com.green.firstserver;

import com.green.firstserver.modelVO.MemoGetOneRes;
import com.green.firstserver.modelVO.MemoGetRes;
import com.green.firstserver.modelVO.MemoPostReq;
import com.green.firstserver.modelVO.MemoPutReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // 빈등록
@RequiredArgsConstructor
public class MemoService {
    // persistence DB 작업 처리 (로직+DB작업)
    private final MemoMapper memoMapper;

    public int insMemo(MemoPostReq req) {
        return memoMapper.insMemo(req);
    }

    public List<MemoGetRes> selMemoList() {
        return memoMapper.selMemoList();
    }

    public MemoGetOneRes selMemo(int id) {
        return memoMapper.selMemo(id);
    }

    public int updMemo(MemoPutReq req) {
        return memoMapper.updMemo(req);
    }

    public int delMemo(int id) {
        return memoMapper.delMemo(id);
    }

}
