package spittr.web;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import spittr.Spittle;
import spittr.data.SpittleRepository;

public class SpittleControllerTest {

    @Test
    public void shouldShowRecentSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(20);
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
        Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/view/spittles.jsp")).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/spittles"))
                .andExpect(MockMvcResultMatchers.view().name("spittles"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittleList")).andExpect(MockMvcResultMatchers
                        .model().attribute("spittleList", CoreMatchers.hasItems(expectedSpittles.toArray())));
    }

    @Test
    public void shouldShowPagedSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(50);
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
        Mockito.when(mockRepository.findSpittles(238900, 50)).thenReturn(expectedSpittles);
        
        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setSingleView(new InternalResourceView("WEB-INF/view/spittles.jsp")).build();
        
        mockMvc.perform(MockMvcRequestBuilders.get("/spittles?max=238900&count=50"))
                .andExpect(MockMvcResultMatchers.view().name("spittles"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittleList")).andExpect(MockMvcResultMatchers
                        .model().attribute("spittleList", CoreMatchers.hasItems(expectedSpittles.toArray())));
    }
    
    @Test
    public void testSpittle() throws Exception {
        Spittle expectedSpittle = new Spittle("Hello", LocalDateTime.now());
        SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
        Mockito.when(mockRepository.findOne(12345)).thenReturn(expectedSpittle);
        
        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        
        mockMvc.perform(MockMvcRequestBuilders.get("/spittles/12345")).andExpect(MockMvcResultMatchers.view().name("spittle")).andExpect(MockMvcResultMatchers.model().attributeExists("spittle")).andExpect(MockMvcResultMatchers.model().attribute("spittle", expectedSpittle));
    }

    private List<Spittle> createSpittleList(int count) {
        return IntStream.range(0, count).mapToObj(i -> new Spittle("Spittle " + i, LocalDateTime.now()))
                .collect(Collectors.toList());
    }

}
