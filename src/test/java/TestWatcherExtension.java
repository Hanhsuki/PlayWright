import jdk.incubator.vector.VectorOperators;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//Delete test trace and video when test success
public class TestWatcherExtension implements TestWatcher, BeforeEachCallback {
    private List<Path> listOfVideoFile = new ArrayList<>();
    @Override
    public void testSuccessful(ExtensionContext context){
        deleteTrace(context);
        deleteVideo();
    }
    private void deleteTrace(ExtensionContext context) {
        Path tracePath = Paths.get(context.getDisplayName().replace("()", "") + ".zip");
        try {
            Files.deleteIfExists(tracePath);
        } catch (IOException e) {
            System.out.println("False to delete trace file with file name" + tracePath.getFileName());
        }
    }

    private void deleteVideo() {
        try {
            List<Path> newVideos = Files.walk(Paths.get("videos/")).filter(Files::isRegularFile).filter(el -> !listOfVideoFile.contains(el)).collect(Collectors.toList());
            for(Path path: newVideos){
                Files.deleteIfExists(path);
            }
        }catch(IOException e){
            System.out.println("Falsed to delete video. Error message was" + e.getMessage());
        }
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        listOfVideoFile = Files.walk(Paths.get("/video")).filter(Files::isRegularFile).collect(Collectors.toList());

    }
}
