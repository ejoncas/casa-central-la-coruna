package uade.server.beans.dto.mapper;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

public class DTOMapper {

	private static Mapper mapper = new DozerBeanMapper();
	
	public DTOMapper(){
	}
	
	public static Object map(Object input, Class<?> dto){
		return mapper.map(input, dto);
	}
	
}
