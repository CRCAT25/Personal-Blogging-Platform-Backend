package net.thanhdevjava.personal_blogging_platform.service;

import net.thanhdevjava.personal_blogging_platform.dto.BlogDTO;
import net.thanhdevjava.personal_blogging_platform.dto.BlogRequest;

import java.util.List;

public interface BlogService {
    BlogDTO createBlog(BlogRequest blogRequest);

    BlogDTO getBlogById(Long id);

    List<BlogDTO> getAllBlogs();

    BlogDTO updateBlog(Long id, BlogRequest blogRequest);

    void deleteBlogById(Long id);
}
