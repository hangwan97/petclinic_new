# Adoption Tab Documentation

## Overview

The Adoption Tab is a new UI feature added to the Spring PetClinic application that displays available pets for adoption in a user-friendly, tabular format. This is a UI-only implementation designed to showcase the interface without backend integration.

## Features

### Navigation
- **Route**: `/adoption`
- **Access**: Available through the main navigation bar or the "Browse Adoptions" button on the welcome page
- **Icon**: Heart icon (❤️) to represent pet adoption

### Pet Adoption Table

The adoption page displays a comprehensive table with the following information for each pet:

| Column | Description |
|--------|-------------|
| **Name** | Pet's name (displayed in bold) |
| **Species / Breed** | Type of animal and breed information |
| **Age** | Pet's age (e.g., "2y" for 2 years, "6m" for 6 months) |
| **Gender** | Male or Female |
| **Status** | Adoption status with color-coded badges:<br>- 🟢 Available (green)<br>- 🟡 Pending (yellow)<br>- ⚫ Adopted (gray) |
| **Date Posted** | Date when the pet was listed for adoption |
| **Action** | View Details button (currently disabled - placeholder for future functionality) |

### Sample Data

The application includes 8 sample pets for demonstration:

1. **Buddy** - Dog / Labrador, 2y, Male, Available
2. **Mittens** - Cat / Domestic Shorthair, 1y, Female, Pending
3. **Charlie** - Dog / Golden Retriever, 3y, Male, Available
4. **Luna** - Cat / Persian, 6m, Female, Available
5. **Max** - Dog / German Shepherd, 4y, Male, Adopted
6. **Bella** - Dog / Beagle, 1y, Female, Available
7. **Oliver** - Cat / Maine Coon, 2y, Male, Pending
8. **Daisy** - Dog / Poodle, 5y, Female, Available

## Technical Architecture

### Backend Components

#### AdoptionController
- **Location**: `src/main/java/org/springframework/samples/petclinic/adoption/AdoptionController.java`
- **Purpose**: Handles HTTP GET requests to `/adoption` endpoint
- **Functionality**: Creates static sample data and passes it to the Thymeleaf template
- **Inner Class**: `AdoptionPet` - POJO representing a pet available for adoption

```java
@Controller
public class AdoptionController {
    @GetMapping("/adoption")
    public String showAdoptionPage(Model model) {
        // Creates and returns sample adoption data
    }
}
```

### Frontend Components

#### Template
- **Location**: `src/main/resources/templates/adoption.html`
- **Technology**: Thymeleaf template engine
- **Framework**: Bootstrap 5.3.3
- **Icons**: Font Awesome 4.7.0

#### Styling
- **Location**: `src/main/resources/static/css/adoption.css`
- **Features**:
  - Responsive design for mobile, tablet, and desktop
  - Table hover effects
  - Color-coded status badges
  - Print-friendly styles
  - Clean, modern appearance

### Dependencies

The adoption feature uses the following technologies:
- **Spring Boot**: 3.4.2
- **Spring MVC**: For controller handling
- **Thymeleaf**: For server-side rendering
- **Bootstrap**: 5.3.3 (via WebJars)
- **Font Awesome**: 4.7.0 (via WebJars)

## Accessibility

The adoption page follows web accessibility best practices:

- ✅ Semantic HTML with proper table structure
- ✅ ARIA labels (`aria-label="Pet adoption list"`)
- ✅ Responsive design works on all device sizes
- ✅ Color-coded status badges with text labels
- ✅ Keyboard navigation support
- ✅ Screen reader friendly

## Responsive Design

The adoption table adapts to different screen sizes:

- **Desktop (>768px)**: Full table with all columns visible
- **Mobile (<768px)**: Reduced font sizes and padding for better fit
- **Print**: Optimized layout with hidden navigation and footer

## Future Enhancements

The following features are planned but not yet implemented:

### Phase 2 - Data Integration
- [ ] Database schema for pet adoption records
- [ ] JPA entities and repositories
- [ ] Database migrations

### Phase 3 - Interactive Features
- [ ] "View Details" functionality with pet detail page
- [ ] Search and filter by species, breed, age, status
- [ ] Pagination for large datasets
- [ ] Sorting by columns

### Phase 4 - Advanced Features
- [ ] Adoption application form
- [ ] Email notifications
- [ ] Admin interface for managing pet listings
- [ ] Photo gallery for each pet
- [ ] Adoption history tracking

## Usage

### Running the Application

1. **Build the application**:
   ```bash
   mvn clean package -DskipTests
   ```

2. **Run the application**:
   ```bash
   java -jar target/spring-petclinic-3.4.0-SNAPSHOT.jar
   ```

3. **Access the application**:
   - Open browser to `http://localhost:8080`
   - Click "Browse Adoptions" or navigate to `http://localhost:8080/adoption`

### Development

To modify the adoption feature:

1. **Update sample data**: Edit `AdoptionController.showAdoptionPage()` method
2. **Change layout**: Modify `src/main/resources/templates/adoption.html`
3. **Update styling**: Edit `src/main/resources/static/css/adoption.css`
4. **Add new fields**: Update both `AdoptionPet` class and HTML template

## Integration Points

The adoption feature integrates with the application through:

1. **Navigation Bar**: Links in `adoption.html` and `welcome.html`
2. **URL Routing**: Spring MVC `@GetMapping("/adoption")`
3. **Static Resources**: CSS served from `/css/adoption.css`
4. **WebJars**: Bootstrap and Font Awesome loaded from `/webjars/`

## Testing

### Manual Testing Checklist

- [x] Page loads without errors
- [x] All 8 sample pets are displayed
- [x] Table columns are properly aligned
- [x] Status badges show correct colors
- [x] Navigation links work correctly
- [x] Page is responsive on mobile devices
- [x] Print layout is clean and readable
- [x] Disabled buttons show proper styling

### Browser Compatibility

Tested and working on:
- ✅ Chrome/Chromium
- ✅ Firefox
- ✅ Safari
- ✅ Edge

## Troubleshooting

### Common Issues

**Issue**: Page returns 404 error
- **Solution**: Ensure the application is running and AdoptionController is loaded

**Issue**: Styles not loading
- **Solution**: Check that WebJars dependencies are in the classpath

**Issue**: Build fails with formatting errors
- **Solution**: Run `mvn spring-javaformat:apply` to auto-fix formatting

## Contributing

To contribute to the adoption feature:

1. Follow the existing code style (Spring Java Format)
2. Ensure all changes are UI-only at this stage
3. Test responsiveness on multiple screen sizes
4. Update this documentation for any new features
5. Run build and verify no errors: `mvn clean package`

## License

Copyright 2012-2019 the original author or authors.

Licensed under the Apache License, Version 2.0.
