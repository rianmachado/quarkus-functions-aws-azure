package rian.example.quarkusfunction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PandemicRequestDTO {
	private String country;
	private int month;
	private int year;
	
	@Override
	public String toString() {
		return "PandemicRequestDTO [country=" + country + ", month=" + month + ", year=" + year + "]";
	}
	
}
