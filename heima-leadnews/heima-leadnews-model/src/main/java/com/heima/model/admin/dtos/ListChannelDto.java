package com.heima.model.admin.dtos;

import lombok.Data;

@Data
public class ListChannelDto {
    private String name;
    private Integer page;
    private Integer size;
    public void checkParam() {
        if (this.page == null || this.page < 0) {
            setPage(1);
        }
        if (this.size == null || this.size < 0 || this.size > 100) {
            setSize(10);
        }
    }

}
