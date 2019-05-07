package cn.saul.lombok;
/**
 * lombok主要常用的注解有：@Data,@getter,@setter,@NoArgsConstructor
 * ,@AllArgsConstructor,@ToString,@EqualsAndHashCode,@Slf4j,@Log4j
 */

import java.util.Date;

import lombok.Data;

/**
 * 测试lombok
 * 
 * @author Saul
 * 2019-05-06
 *
 */
@Data
public class Car {
	
	private String name;
	
	private String model;
	
	private Date produceDate;

}
