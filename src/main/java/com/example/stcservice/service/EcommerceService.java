package com.example.stcservice.service;

import com.example.stcservice.dto.CategoryDTO;
import com.example.stcservice.dto.OrderDTO;
import com.example.stcservice.dto.ProductDTO;
import com.example.stcservice.entity.Category;
import com.example.stcservice.entity.Product;
import com.example.stcservice.repo.CategoryRepository;
import com.example.stcservice.repo.OrderRepository;
import com.example.stcservice.repo.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service // spring annotation - Bean
//@Component // spring annotation
//@Configuration // spring annotation
//@Repository // spring annotation
// @Autowired injection - constructor injection - setter injection
// @Qualifier //
// @Bean
@AllArgsConstructor
public class EcommerceService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products
                .stream()
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getSearchProducts(String keyword) {
        String asLowerCase = keyword.toLowerCase();
        return productRepository.findAll().stream()
                .filter(product -> product.getName().toLowerCase().contains(asLowerCase))
                .map(product -> modelMapper.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId)
                .stream()
                .map(product -> {
                    ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
//                    productDTO.setCategoryId(product.getCategoryId());
//                    productDTO.setCategoryName(product.getName());
                    return productDTO;
                })
                .collect(Collectors.toList());
    }

    public ProductDTO addProduct(ProductDTO productDTO){
        Product productEntity = modelMapper.map(productDTO, Product.class);
//        Category category = new Category();
//        category.setId(productDTO.getCategoryId());
//        productEntity.setCategory(category);
        productEntity = productRepository.save(productEntity);
        return modelMapper.map(productEntity, ProductDTO.class);
    }

    public boolean deleteProduct(Long id){
        if (!productRepository.existsById(id)){
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }

    public Product getProductById(Long id){
        Product product = productRepository.findById(id);
        return product;
        //return modelMapper.map(product, ProductDTO.class);
        //throw new NoSuchElementException("Product not found");
    }

    public ProductDTO updateProduct(ProductDTO productDTO){
        if (productRepository.existsById(productDTO.getId())) {
            return modelMapper.map(
                    productRepository.save(modelMapper.map(productDTO, Product.class)),
                    ProductDTO.class
            );
        }
        throw new NoSuchElementException("Product not found");
    }

    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(Collectors.toList());
    }

    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        boolean isExistCategory = categoryRepository.findAll()
                .stream()
                .anyMatch(category -> category.getName().equalsIgnoreCase(categoryDTO.getName()));

        if (isExistCategory) return null;

        Category categoryEntity = categoryRepository.save(modelMapper.map(categoryDTO, Category.class));
        return modelMapper.map(categoryEntity, CategoryDTO.class);
    }

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> modelMapper.map(order, OrderDTO.class))
                .collect(Collectors.toList());
    }

}