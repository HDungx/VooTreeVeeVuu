package com.VooTreeVeeVuu.dto;

import com.VooTreeVeeVuu.domain.entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelImageDTO {
    private Long id;
    private String path;
}
