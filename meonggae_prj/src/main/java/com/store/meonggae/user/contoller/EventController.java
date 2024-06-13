package com.store.meonggae.user.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.store.meonggae.event.service.EventService;
import com.store.meonggae.event.domain.EventDomain;
import com.store.meonggae.event.vo.PagingVO;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/event_page/event_main.do")
    public String eventMain(Model model, 
                            @RequestParam(defaultValue = "1") int currentPage, 
                            @RequestParam(required = false) String keyword, 
                            @RequestParam(required = false) String field) {
        PagingVO pVO = eventService.createPagingVO(keyword, field, currentPage);

        List<EventDomain> eventList = eventService.selectEvent(pVO);

        model.addAttribute("eventList", eventList);
        model.addAttribute("totalCnt", pVO.getTotalCount());
        model.addAttribute("pageScale", pVO.getPageScale());
        model.addAttribute("currentPage", pVO.getCurrentPage());
        model.addAttribute("totalPage", (int) Math.ceil((double) pVO.getTotalCount() / pVO.getPageScale()));
        model.addAttribute("paging", eventService.pageNation("/event_page/event_main.do", "", (int) Math.ceil((double) pVO.getTotalCount() / pVO.getPageScale()), pVO.getCurrentPage()));

        return "event_page/event_main";
    }

    @GetMapping("/event_page/event_detail.do")
    public String eventDetail(Model model, @RequestParam("event-code") int eventNum) {
        EventDomain eventDetail = eventService.selectDetailEvent(eventNum);
        model.addAttribute("eventDetail", eventDetail);
        return "event_page/event_detail";
    }

    @GetMapping("/event_page/event_handler.do")
    public String eventHandler() {
        return "event_page/event_handler";
    }
}


/*
 * @Controller public class EventController {
 * 
 * @GetMapping("/event_page/event_main.do") public String event() { return
 * "event_page/event_main"; }
 * 
 * @GetMapping("/event_page/event_handler.do") public String eventHandler() {
 * return "/event_page/event_handler"; }
 * 
 * @GetMapping("/event_page/event_detail.do") public String eventDetail() {
 * return "/event_page/event_detail"; }
 * 
 * }
 */
