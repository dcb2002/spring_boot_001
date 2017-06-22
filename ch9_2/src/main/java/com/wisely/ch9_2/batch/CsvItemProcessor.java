package com.wisely.ch9_2.batch;

import org.springframework.batch.item.validator.ValidatingItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

import com.wisely.ch9_2.domain.Person;

public class CsvItemProcessor  extends ValidatingItemProcessor<Person>{

	@Override
	public Person process(Person item) throws ValidationException {
		super.process(item); //【1】必须执行 super.process()方法，才能调用自定义的校验器。
		
		if(item.getNation().equals("汉族")){ //2
			item.setNation("01");
		}else{
			item.setNation("02");
		}
		return item;
	}


}
