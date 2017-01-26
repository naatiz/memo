/*
 * Copyright 2014, NATIZ and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the 
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cg.natiz.memo;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

import cg.natiz.memo.prognosis.Prognosis;

/**
 * 
 * @author natiz
 * 
 */
public class Resources {
	
	@Inject
	private Prognosis prognosis;

	// Expose logger using the resource producer pattern
	@Produces
	Logger getLogger(InjectionPoint ip) {
		String category = ip.getMember().getDeclaringClass().getName();
		return Logger.getLogger(category);
	}

	// DOUBLE is the default prognosis type of config
	@Produces @Config
	public Prognosis getEvent(InjectionPoint injectionPoint) {
		Config config = injectionPoint.getAnnotated().getAnnotation(
				Config.class);
		prognosis.getEvent().setName(config.name());
		prognosis.getEvent().setLength(config.length());
		prognosis.getEvent().setType(config.type()); 	
		return prognosis;
	}
}
