package net.thanhdevjava.personal_blogging_platform.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogDTO {
    public Long id;
    public String title;
    public String content;
    public String author;
    public String createdDate;
    public String updatedDate;
    public String imageUrl;
    public String status;
}