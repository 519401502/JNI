package com.example.aml.clearn

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.text.Html
import android.text.SpannableString
import android.text.method.ScrollingMovementMethod
import android.webkit.WebView
import android.widget.TextView

class NineActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nine)
//        val spannableString = Html.fromHtml()
        val webView = findViewById<WebView>(R.id.web_view)
//        val intent = Intent()
//        intent.action = "com.android.launcher.action.INSTALL_SHORTCUT"
//        intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "快捷图标")
//        intent.putExtra(Intent.EXTRA_SHORTCUT_ICON, BitmapFactory.decodeResource(resources, R.drawable.image1))
//        val doIntent = Intent()
//        doIntent.action = "com.example.aml.clearn.SevenActivity"
//        intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, doIntent)
//        sendBroadcast(intent)

        val textView = findViewById<TextView>(R.id.text_view)
        textView.text = Html.fromHtml("<h1>装饰器模式</h1>\n" +
                "<p>装饰器模式（Decorator Pattern）允许向一个现有的对象添加新的功能，同时又不改变其结构。这种类型的设计模式属于结构型模式，它是作为现有的类的一个包装。</p>\n" +
                "<p>这种模式创建了一个装饰类，用来包装原有的类，并在保持类方法签名完整性的前提下，提供了额外的功能。</p>\n" +
                "<p>我们通过下面的实例来演示装饰器模式的用法。其中，我们将把一个形状装饰上不同的颜色，同时又不改变形状类。</p>\n" +
                "<h2 class=\"tutheader\">介绍</h2>\n" +
                "<p><b>意图：</b>动态地给一个对象添加一些额外的职责。就增加功能来说，装饰器模式相比生成子类更为灵活。</p>\n" +
                "<p><b>主要解决：</b>一般的，我们为了扩展一个类经常使用继承方式实现，由于继承为类引入静态特征，并且随着扩展功能的增多，子类会很膨胀。</p>\n" +
                "<p><b>何时使用：</b>在不想增加很多子类的情况下扩展类。</p>\n" +
                "<p><b>如何解决：</b>将具体功能职责划分，同时继承装饰者模式。</p>\n" +
                "<p><b>关键代码：</b>\n" +
                "1、Component 类充当抽象角色，不应该具体实现。\n" +
                "2、修饰类引用和继承 Component 类，具体扩展类重写父类方法。\n" +
                "</p>\n" +
                "<p><b>应用实例：</b>\n" +
                "1、孙悟空有 72 变，当他变成\"庙宇\"后，他的根本还是一只猴子，但是他又有了庙宇的功能。\n" +
                "2、不论一幅画有没有画框都可以挂在墙上，但是通常都是有画框的，并且实际上是画框被挂在墙上。在挂在墙上之前，画可以被蒙上玻璃，装到框子里；这时画、玻璃和画框形成了一个物体。\n" +
                "</p>\n" +
                "<p><b>优点：</b>装饰类和被装饰类可以独立发展，不会相互耦合，装饰模式是继承的一个替代模式，装饰模式可以动态扩展一个实现类的功能。</p>\n" +
                "<p><b>缺点：</b>多层装饰比较复杂。</p>\n" +
                "<p><b>使用场景：</b>\n" +
                "1、扩展一个类的功能。\n" +
                "2、动态增加功能，动态撤销。\n" +
                "</p>\n" +
                "<p><b>注意事项：</b>可代替继承。</p>\n" +
                "<h2 class=\"tutheader\">实现</h2>\n" +
                "<p>我们将创建一个 <i>Shape</i> 接口和实现了 <i>Shape</i> 接口的实体类。然后我们创建一个实现了 <i>Shape</i> 接口的抽象装饰类 <i>ShapeDecorator</i>，并把 <i>Shape</i> 对象作为它的实例变量。</p>\n" +
                "<p><i>RedShapeDecorator</i> 是实现了 <i>ShapeDecorator</i> 的实体类。<p><i>DecoratorPatternDemo</i>，我们的演示类使用 <i>RedShapeDecorator</i> 来装饰 <i>Shape</i> 对象。</p>\n" +
                "<img alt=\"装饰器模式的 UML 图\" src=\"/wp-content/uploads/2014/08/decorator_pattern_uml_diagram.jpg\"/>\n" +
                "<h3>步骤 1</h3>\n" +
                "<p>创建一个接口。</p>\n" +
                "<p><i>Shape.java</i></p>\n" +
                "<pre class=\"prettyprint\">\n" +
                "public interface Shape {\n" +
                "   void draw();\n" +
                "}\n" +
                "</pre>\n" +
                "<h3>步骤 2</h3>\n" +
                "<p>创建实现接口的实体类。</p>\n" +
                "<p><i>Rectangle.java</i></p>\n" +
                "<pre class=\"prettyprint\">\n" +
                "public class Rectangle implements Shape {\n" +
                "\n" +
                "   @Override\n" +
                "   public void draw() {\n" +
                "      System.out.println(\"Shape: Rectangle\");\n" +
                "   }\n" +
                "}\n" +
                "</pre>\n" +
                "<p><i>Circle.java</i></p>\n" +
                "<pre class=\"prettyprint\">\n" +
                "public class Circle implements Shape {\n" +
                "\n" +
                "   @Override\n" +
                "   public void draw() {\n" +
                "      System.out.println(\"Shape: Circle\");\n" +
                "   }\n" +
                "}\n" +
                "</pre>\n" +
                "<h3>步骤 3</h3>\n" +
                "<p>创建实现了 <i>Shape</i> 接口的抽象装饰类。</p>\n" +
                "<p><i>ShapeDecorator.java</i></p>\n" +
                "<pre class=\"prettyprint\">\n" +
                "public abstract class ShapeDecorator implements Shape {\n" +
                "   protected Shape decoratedShape;\n" +
                "\n" +
                "   public ShapeDecorator(Shape decoratedShape){\n" +
                "      this.decoratedShape = decoratedShape;\n" +
                "   }\n" +
                "\n" +
                "   public void draw(){\n" +
                "      decoratedShape.draw();\n" +
                "   }    \n" +
                "}\n" +
                "</pre>\n" +
                "<h3>步骤 4</h3>\n" +
                "<p>创建扩展了 <i>ShapeDecorator</i> 类的实体装饰类。</p>\n" +
                "<p><i>RedShapeDecorator.java</i></p>\n" +
                "<pre class=\"prettyprint\">\n" +
                "public class RedShapeDecorator extends ShapeDecorator {\n" +
                "\n" +
                "   public RedShapeDecorator(Shape decoratedShape) {\n" +
                "      super(decoratedShape);        \n" +
                "   }\n" +
                "\n" +
                "   @Override\n" +
                "   public void draw() {\n" +
                "      decoratedShape.draw();           \n" +
                "      setRedBorder(decoratedShape);\n" +
                "   }\n" +
                "\n" +
                "   private void setRedBorder(Shape decoratedShape){\n" +
                "      System.out.println(\"Border Color: Red\");\n" +
                "   }\n" +
                "}\n" +
                "</pre>\n" +
                "<h3>步骤 5</h3>\n" +
                "<p>使用 <i>RedShapeDecorator</i> 来装饰 <i>Shape</i> 对象。</p>\n" +
                "<p><i>DecoratorPatternDemo.java</i></p>\n" +
                "<pre class=\"prettyprint\">\n" +
                "public class DecoratorPatternDemo {\n" +
                "   public static void main(String[] args) {\n" +
                "\n" +
                "      Shape circle = new Circle();\n" +
                "\n" +
                "      Shape redCircle = new RedShapeDecorator(new Circle());\n" +
                "\n" +
                "      Shape redRectangle = new RedShapeDecorator(new Rectangle());\n" +
                "      System.out.println(\"Circle with normal border\");\n" +
                "      circle.draw();\n" +
                "\n" +
                "      System.out.println(\"\\nCircle of red border\");\n" +
                "      redCircle.draw();\n" +
                "\n" +
                "      System.out.println(\"\\nRectangle of red border\");\n" +
                "      redRectangle.draw();\n" +
                "   }\n" +
                "}\n" +
                "</pre>\n" +
                "<h3>步骤 6</h3>\n" +
                "<p>验证输出。</p>\n" +
                "<pre class=\"result\">\n" +
                "Circle with normal border\n" +
                "Shape: Circle\n" +
                "\n" +
                "Circle of red border\n" +
                "Shape: Circle\n" +
                "Border Color: Red\n" +
                "\n" +
                "Rectangle of red border\n" +
                "Shape: Rectangle\n" +
                "Border Color: Red\n" +
                "</pre>\n" +
                "</p>")
        textView.movementMethod = ScrollingMovementMethod.getInstance()
    }
}