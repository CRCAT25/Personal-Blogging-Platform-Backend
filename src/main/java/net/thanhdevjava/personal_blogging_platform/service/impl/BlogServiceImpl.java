package net.thanhdevjava.personal_blogging_platform.service.impl;

import lombok.AllArgsConstructor;
import net.thanhdevjava.personal_blogging_platform.dto.BlogDTO;
import net.thanhdevjava.personal_blogging_platform.dto.BlogRequest;
import net.thanhdevjava.personal_blogging_platform.enity.Blog;
import net.thanhdevjava.personal_blogging_platform.exception.ResourceNotFoundException;
import net.thanhdevjava.personal_blogging_platform.mapper.BlogMapper;
import net.thanhdevjava.personal_blogging_platform.repository.BlogRepository;
import net.thanhdevjava.personal_blogging_platform.service.BlogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements BlogService {

    private BlogRepository blogRepository;

    @Override
    public BlogDTO createBlog(BlogRequest blogRequest) {
        BlogDTO blogDTO = new BlogDTO();

        blogDTO.setAuthor(blogRequest.getAuthor());
        blogDTO.setContent(blogRequest.getContent());
        blogDTO.setImageUrl(blogRequest.getImageUrl());
        blogDTO.setStatus(blogRequest.getStatus());
        blogDTO.setTitle(blogRequest.getTitle());

        blogDTO.setCreatedDate(LocalDateTime.now().toString());
        blogDTO.setUpdatedDate(LocalDateTime.now().toString());

        blogRepository.save(BlogMapper.mapToBlog(blogDTO));
        return blogDTO;
    }

    @Override
    public BlogDTO getBlogById(Long id) {
        Blog blog = blogRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found blog with id: " + id));
        return BlogMapper.mapToBlogDTO(blog);
    }

    @Override
    public List<BlogDTO> getAllBlogs() {
        List<Blog> blogs = blogRepository.findAll();
        return blogs.stream().map(BlogMapper::mapToBlogDTO).toList();
    }

    @Override
    public BlogDTO updateBlog(Long id, BlogRequest blogRequest) {
        Blog blog = blogRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found blog with id: " + id));

        blog.setTitle(blogRequest.getTitle());
        blog.setContent(blogRequest.getContent());
        blog.setAuthor(blogRequest.getAuthor());
        blog.setImageUrl(blogRequest.getImageUrl());
        blog.setUpdatedDate(LocalDateTime.now().toString());

        blogRepository.save(blog);
        return BlogMapper.mapToBlogDTO(blog);
    }

    @Override
    public void deleteBlogById(Long id) {
        Blog blog = blogRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found blog with id: " + id));

        blogRepository.delete(blog);
    }
}
