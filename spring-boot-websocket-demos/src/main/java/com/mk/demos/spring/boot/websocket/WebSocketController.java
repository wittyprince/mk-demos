package com.mk.demos.spring.boot.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Date;

/**
 * WebSocket Controller
 *
 * @author WangChen
 * Created on 2022/9/3
 * @since 1.0
 */
@Controller
@RequestMapping("/websocket")
public class WebSocketController {

    /**
     * 页面请求
     */
    @GetMapping("/{cid}")
    public ModelAndView socket(@PathVariable String cid) {
        ModelAndView mav = new ModelAndView("/socket");
        mav.addObject("cid", cid);
        return mav;
    }

    @GetMapping("/health/{cid}")
    @ResponseBody
    public String health(@PathVariable String cid) {
        ModelAndView mav = new ModelAndView("/socket");
        mav.addObject("cid", cid);
        return "health..." + cid;
    }

    /**
     * 推送数据接口
     */
    @ResponseBody
    @PostMapping("/send")
    public DemoResponse pushToWeb(@RequestBody DemoRequest request) {
        try {
            SocketMessage newMessage = new SocketMessage(request.getMsg(), request.getRoomId(), new Date());
            WebSocketServer.sendInfo(request.getRoomId(), newMessage);
        } catch (IOException e) {
            e.printStackTrace();
//            return request.getUid() + "#" + e.getMessage();
        }
        return new DemoResponse(0, "ok..." + request.getMsg());
    }
}
