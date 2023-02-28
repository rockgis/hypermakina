package com.mslk.hypermakina.board.controller;

import com.mslk.common.paging.Pagination;
import com.mslk.common.paging.dto.SearchDto;
import com.mslk.hypermakina.board.dto.BoardDto;
import com.mslk.hypermakina.board.service.BoardService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
public class NoticeController {
    private BoardService boardService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /* 게시글 목록 */
    @GetMapping("/admin/notice")
    public String notice(Model model, @ModelAttribute("params") final SearchDto params) {

        List<BoardDto> boardList = boardService.getBoardlist(params.getPage());
        // 총 게시글 갯수
        double  count = Double.valueOf(boardService.getBoardCount());
        Integer postsTotalCount = (int) count;

        logger.info("params : " + params.getPage());


        Pagination pagination = new Pagination(postsTotalCount, params);

        logger.info("totalRecordCount : " + pagination.getTotalRecordCount());
        logger.info("totalPageCount : " + pagination.getTotalPageCount());
        logger.info("startPage : " + pagination.getStartPage());
        logger.info("endPage : " + pagination.getEndPage());
        logger.info("limitStart : " + pagination.getLimitStart());
        logger.info("existPrevPage : " + pagination.isExistPrevPage());
        logger.info("existNextPage : " + pagination.isExistNextPage());


        model.addAttribute("boardList", boardList);
        model.addAttribute("pagination", pagination);

        return "notice/main";
    }

    /* 게시글 상세 */
    @GetMapping("/admin/post/{no}")
    public String admindetail(@PathVariable("no") Long no, Model model) {
        BoardDto boardDTO = boardService.getPost(no);

        model.addAttribute("boardDto", boardDTO);
        return "notice/detail";
    }

    /* 게시글 쓰기 */
    @GetMapping("/admin/post")
    public String adminwrite() {
        return "board/write.html";
    }

    @PostMapping("/admin/post")
    public String adminwrite(Principal principal, BoardDto boardDto) {

        boardDto.setWriter(principal.getName());

        boardService.savePost(boardDto);

        return "redirect:/admin/notice";
    }

    /* 게시글 수정 */
    @GetMapping("/admin/post/edit/{no}")
    public String adminedit(@PathVariable("no") Long no, Model model) {
        BoardDto boardDTO = boardService.getPost(no);

        model.addAttribute("boardDto", boardDTO);
        return "notice/update";
    }

    @PutMapping("/admin/post/edit/{no}")
    public String adminupdate(BoardDto boardDTO) {
        boardService.savePost(boardDTO);

        return "redirect:/admin/notice";
    }

    /* 게시글 삭제 */
    @DeleteMapping("/admin/post/{no}")
    public String admindelete(@PathVariable("no") Long no) {
        boardService.deletePost(no);

        return "redirect:/admin/notice";
    }

    @PostMapping("/admin/search")
    public String adminsearch(@RequestParam(value="keyword") String keyword, @ModelAttribute("params") final SearchDto params , Model model) {

        logger.info("/admin/search : "+keyword);

        List<BoardDto> boardList = boardService.searchPosts(keyword);

        // 총 게시글 갯수
        double  count = Double.valueOf(boardList.size());

        Integer postsTotalCount = (int) count;

        Pagination pagination = new Pagination(postsTotalCount, params);

        model.addAttribute("boardList", boardList);
        model.addAttribute("pagination", pagination);

        return "notice/search";
    }
}
