package com.go2climb.travel.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "travels")
@AllArgsConstructor
@NoArgsConstructor
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 1, max = 75)
    @NotBlank
    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @NotBlank
    @Column(name = "photo_logo")
    private String photoLogo;

    @Size(max = 1000)
    @Column(name = "description")
    private String description;

    @Column(name = "stars")
    private Integer stars;

    @Column(name = "price")
    private Integer price;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(name = "location")
    private String location;

    @NotNull
    @NotBlank
    @Column(name = "photo_portada")
    private String photoPortada;

    @NotNull
    @NotBlank
    @Column(name = "photo1")
    private String photo1;

    @NotNull
    @NotBlank
    @Column(name = "photo2")
    private String photo2;

    @NotNull
    @NotBlank
    @Column(name = "photo3")
    private String photo3;

    @NotNull
    @NotBlank
    @Column(name = "photo4")
    private String photo4;

    @Column(name = "created_date")
    private String createdDate;

    @Column(name = "agency")
    private Integer agency;

//    @ManyToOne()
//    @JoinColumn(name = "agency_id")
//    @JsonIgnoreProperties({"travels"})
//    private Agency agency;
//
//    @JsonIgnoreProperties({"travel"})
//    @OneToMany(mappedBy = "travel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<Activity> activities;
//
//    @JsonIgnoreProperties({"travel"})
//    @OneToMany(mappedBy = "travel", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<Tip> tips;
}