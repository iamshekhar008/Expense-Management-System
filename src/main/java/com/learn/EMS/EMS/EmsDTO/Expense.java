    package com.learn.EMS.EMS.EmsDTO;

    import jakarta.validation.constraints.NotBlank;
    import jakarta.validation.constraints.NotNull;
    import jakarta.validation.constraints.Pattern;
    import jakarta.validation.constraints.Positive;
    import org.hibernate.annotations.Type;

    public class Expense {
        private Long id;
        @NotBlank(message = "Name cant be Blank/null")
        private String name;
        @Positive(message = "Cost hast to be greater than Zero")
        private double cost;
        @NotBlank(message = "Your Type cant be blank")
        @Pattern(regexp = "Food|Travel|Rent|Utility|Entertainment|Other",
                message = "Type must be one of: Food, Travel, Rent, Utility, Entertainment, Other")
        private String type;
        public Expense(){

        }

        public Expense(Long id, String name, double cost, String type) {
            this.id = id;
            this.name = name;
            this.cost = cost;
            this.type = type;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
