package com.example.demo.dto;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequestDTO {
	
	@NotBlank(message = "Name is required")
	private String name;
	
	@Email(message = "email format is incorrect")
	private String email;
	
	@NotNull(message = "Phone Number is required")
	private Long phoneNumber;
	
	@NotBlank(message = "Address is required")
	private String address;
}
