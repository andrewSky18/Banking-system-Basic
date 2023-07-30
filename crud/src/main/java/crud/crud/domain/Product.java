package crud.crud.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name="Product")
    public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private Short noRepaymentMin;

    @Column
    private Short noRepaymentMax;

    @Column
    private Long principalMin;

    @Column
    private Long principalMax;

    @Column
    private Long commission;

    @Column
    private Long fees;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "product_id")
    @JsonIgnore

    private List<Loan> loans;

    public static Product CreateProduct(ProductDTO productDTO) {
        Product product = Product.builder()
                .name(productDTO.getName())
                .noRepaymentMin(productDTO.getNoRepaymentMin())
                .noRepaymentMax(productDTO.getNoRepaymentMax())
                .principalMin(productDTO.getPrincipalMin())
                .principalMax(productDTO.getPrincipalMax())
                .commission(productDTO.getCommission())
                .fees(productDTO.getFees())
                .build();
        return product;
    }
    public static Product updateProduct(ProductDTO productDTO,Product product) {
        product.setName(productDTO.getName());
        product.setNoRepaymentMin(productDTO.getNoRepaymentMin());
        product.setNoRepaymentMax(product.getNoRepaymentMax());
        product.setPrincipalMin(product.getPrincipalMin());
        product.setPrincipalMax(product.getPrincipalMax());
        product.setFees(product.getFees());
        product.setCommission(product.getCommission());
        return product;
    }

}
