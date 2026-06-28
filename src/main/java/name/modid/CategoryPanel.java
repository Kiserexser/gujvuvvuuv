package name.modid;

import net.minecraft.client.gui.DrawContext;

import java.util.ArrayList;
import java.util.List;

public class CategoryPanel {
    private final String title;
    private final int x, y;
    private final int width = 200;
    private final int height = 380;

    private final List<String> modules = new ArrayList<>();

    public CategoryPanel(String title, int x, int y) {
        this.title = title;
        this.x = x;
        this.y = y;

        modules.add("Anti Bot");
        modules.add("Attack Aura");
        modules.add("Auto Totem");
        modules.add("Hit Boxes");
        modules.add("Flight");
        modules.add("Fullbright");
        modules.add("ESP");
        modules.add("Auto Armor");
        modules.add("Fast Place");
    }

    public void render(DrawContext context, int mouseX, int mouseY) {
        // Тёмный глубокий фон + слабое закругление
        drawRoundedRect(context, x, y, x + width, y + height, 0xFF0A0A0A, 8);

        // Заголовок (зелёный акцент)
        context.drawText(mc.textRenderer, "§a" + title, x + 12, y + 12, 0xFF00FF88, true);

        int moduleY = y + 45;
        for (String module : modules) {
            boolean hovered = mouseX > x + 8 && mouseX < x + width - 8 && mouseY > moduleY && mouseY < moduleY + 24;

            int bgColor = hovered ? 0xFF1A3C2E : 0xFF111111;
            drawRoundedRect(context, x + 8, moduleY, x + width - 8, moduleY + 24, bgColor, 6);

            context.drawText(mc.textRenderer, module, x + 16, moduleY + 8, 0xFFCCCCCC, false);

            moduleY += 30;
        }
    }

    private void drawRoundedRect(DrawContext context, int x1, int y1, int x2, int y2, int color, int radius) {
        context.fill(x1 + radius, y1, x2 - radius, y2, color);
        context.fill(x1, y1 + radius, x2, y2 - radius, color);
        context.fill(x1, y1, x1 + radius, y1 + radius, color);
        context.fill(x2 - radius, y1, x2, y1 + radius, color);
        context.fill(x1, y2 - radius, x1 + radius, y2, color);
        context.fill(x2 - radius, y2 - radius, x2, y2, color);
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {
        // Позже добавим toggle
    }
}
