package com.mk.demos.spring.boot.websocket;

/**
 * demo bo
 *
 * @author WangChen
 * Created on 2022/9/4
 * @since 1.0
 */
public class DemoBO {

    private Long id;
    private String name;

    /**
     * org.springframework.data.redis.serializer.SerializationException:
     * Could not read JSON:
     * Cannot construct instance of `com.mk.demos.spring.boot.websocket.DemoBO` (no Creators, like default construct, exist):
     * cannot deserialize from Object value (no delegate- or property-based Creator)
     */
    public DemoBO() {
    }

    public DemoBO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
