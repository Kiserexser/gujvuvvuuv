package name.modid;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

import java.util.ArrayList;
import java.util.List;

public class ClickGUI {
    private static final MinecraftClient mc = MinecraftClient.getInstance();
    private boolean open = false;

    private final List<CategoryPanel> panels = new ArrayList<>();

    public ClickGUI() {
        int startX = 50;
        int spacing = 220;

        panels.add(new CategoryPanel("Combat", startX, 40));
        panels.add(new CategoryPanel("Movement", startX + spacing, 40));
        panels.add(new CategoryPanel("Visuals", startX + spacing * 2, 40));
        panels.add(new CategoryPanel("Player", startX + spacing * 3, 40));
        panels.add(new CategoryPanel("Misc", startX + spacing * 4, 40));
    }

    public void toggle() {
        open = !open;
    }

    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        if (!open) return;

        for (CategoryPanel panel : panels) {
            panel.render(context, mouseX, mouseY);
        }
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (!open) return;
        for (CategoryPanel panel : panels) {
            panel.mouseClicked(mouseX, mouseY, button);
        }
    }
}
