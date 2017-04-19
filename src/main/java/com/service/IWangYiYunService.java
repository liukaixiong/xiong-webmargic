package com.service;

import com.model.common.ResultDTO;
import com.webmargic.vo.CommentVO;

/**
 * @author Liukx
 * @create 2017-03-28 14:48
 * @email liukx@elab-plus.com
 **/
public interface IWangYiYunService {
    public void insertMusic(CommentVO vo);

    /**
     * 网易云歌手或者歌曲url地址
     *
     * @param url
     */
    public ResultDTO wyyCrawler(String url);
}
