package net.thanhdevjava.personal_blogging_platform.mapper;

import net.thanhdevjava.personal_blogging_platform.dto.BlogDTO;
import net.thanhdevjava.personal_blogging_platform.enity.Blog;


public class BlogMapper {

    public static Blog mapToBlog(BlogDTO blogDTO) {
        return new Blog(
                blogDTO.getId(),
                blogDTO.getTitle(),
                blogDTO.getContent(),
                blogDTO.getAuthor(),
                blogDTO.getCreatedDate(),
                blogDTO.getUpdatedDate(),
                blogDTO.getImageUrl(),
                blogDTO.getStatus()
        );
    }

    public static BlogDTO mapToBlogDTO (Blog blog){
        return new BlogDTO(
                blog.getId(),
                blog.getTitle(),
                blog.getContent(),
                blog.getAuthor(),
                blog.getCreatedDate(),
                blog.getUpdatedDate(),
                blog.getImageUrl(),
                blog.getStatus()
        );
    }
}
