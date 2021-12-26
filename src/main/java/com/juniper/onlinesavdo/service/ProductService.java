package com.juniper.onlinesavdo.service;

import com.juniper.onlinesavdo.entity.Product;
import com.juniper.onlinesavdo.payload.request.ProductReqDto;
import com.juniper.onlinesavdo.payload.responce.ProductResDto;
import com.juniper.onlinesavdo.repository.FileStorageRepository;
import com.juniper.onlinesavdo.repository.PartRepository;
import com.juniper.onlinesavdo.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private FileStorageRepository fileStorageRepository;

    @Autowired
    private PartRepository partRepository;

    ModelMapper modelMapper=new ModelMapper();

    public String saveProduct(ProductReqDto productReqDto)
    {
        Product product=modelMapper.map(productReqDto,Product.class);
        product.setFileStorage(fileStorageRepository.findByhashid(productReqDto.getHashid()));
        product.setParts(partRepository.getById(productReqDto.getPartId()));
        productRepository.save(product);
        return "saved";
    }

    public List<ProductResDto> getAllProduct()
    {
        List<Product> products=productRepository.findAll();
        List<ProductResDto> productResDtos=new ArrayList<>();
        for (int i=0;i<products.size();i++)
        {
            productResDtos.add(modelMapper.map(products.get(i),ProductResDto.class));
            productResDtos.get(i).setHashid(products.get(i).getFileStorage().getHashId());
            productResDtos.get(i).setPartId(products.get(i).getParts().getId());
        }

        return productResDtos;
    }

}
