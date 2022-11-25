package com.smirnov.Company.configuration;

import com.smirnov.Company.model.Employee;
import com.smirnov.Company.model.Project;
import com.smirnov.Company.model.dto.EmployeeDto;
import com.smirnov.Company.model.dto.ProjectDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappingConfiguration {
    @Bean
    public ModelMapper getEmployeeDtoMapper() {
        PropertyMap<Employee, EmployeeDto> empMap = new PropertyMap<>() {
            protected void configure() {
                map().setId(source.getEmployeeID());
                map().setProjectId(source.getProjectID());
                map().setFirstName(source.getFirstname());
                map().setLastName(source.getLastname());
                map().setEmail(source.getEmail());
            }
        };
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.addMappings(empMap);

        return modelMapper;
    }

    @Bean
    public ModelMapper getEmployeeMapper() {
        PropertyMap<EmployeeDto, Employee> empMap = new PropertyMap<>() {
            protected void configure() {
                map().setEmployeeID(source.getId());
                map().setProjectID(source.getProjectId());
                map().setFirstname(source.getFirstName());
                map().setLastname(source.getLastName());
                map().setEmail(source.getEmail());
            }
        };
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.addMappings(empMap);

        return modelMapper;
    }

    @Bean
    public ModelMapper getProjectDtoMapper() {
        PropertyMap<Project, ProjectDto> empMap = new PropertyMap<>() {
            protected void configure() {
                map().setId(source.getProjectID());
                map().setName(source.getName());
                map().setCustomer(source.getCustomer());
                map().setDescription(source.getDescription());
            }
        };
        System.out.println(empMap);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.addMappings(empMap);

        return modelMapper;
    }

    @Bean
    public ModelMapper getProjectMapper() {
        PropertyMap<ProjectDto, Project> empMap = new PropertyMap<>() {
            protected void configure() {
                map().setProjectID(source.getId());
                map().setName(source.getName());
                map().setCustomer(source.getCustomer());
                map().setDescription(source.getDescription());
            }
        };
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.addMappings(empMap);

        return modelMapper;
    }
}
