package com.learningrestapi.LearningRESTApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private long id;
    private String name;
    private String email;

    /**
     * Generally we have to write these boilerplate code, but as we have added dependency of lombok we just need to provide annotation @Data
     *
     * @AllArgsConstructor it replaces this all field construct
        public StudentDto(long id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        public StudentDto() {
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
     */
}
