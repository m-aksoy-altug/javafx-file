package com.javafx.validation;

import java.util.Optional;

import com.javafx.exception.InvalidFileException;
import com.javafx.helper.Constants;

public class Validator  {
	
	/*
	 * - TODO check allowed chars for creating a file name, this is platform dependent.
	 * - While list is easy and safe approach like [a-z,A-Z,0-9,_,-]
	 *  
	*/
	public static String fileNameMapper(Optional<String> fileName) throws InvalidFileException {
		if(!fileName.isPresent()) {
			throw new InvalidFileException(Constants.FILE_NAME_IS_NOT_VALID);
		}
		else {
			String input= fileName.get();
			if(input==null || input.isBlank()) {
				throw new InvalidFileException(Constants.FILE_NAME_IS_EMPTY);
			}
			else if(input.length()>255-3) {
				throw new InvalidFileException(Constants.FILE_NAME_MAX_CHAR);
			}
			if(!input.endsWith(Constants.TXT_PREFIX)) {
				input= input+Constants.TXT_PREFIX;
			}
			if (!input.matches(Constants.FILE_NAME_REGEX)) {
				throw new InvalidFileException(Constants.FILE_CONTAINS_NOT_ALLOWED_CHARACTERS);
			}
			return input;
		}
	}
	
}
